import {
  S3,
  GetObjectCommand,
  S3Client,
  PutObjectCommand,
} from '@aws-sdk/client-s3';
import { Upload } from '@aws-sdk/lib-storage';
import { Injectable, StreamableFile } from '@nestjs/common';
import { createReadStream } from 'fs';
import internal, { Readable, Stream } from 'stream';

@Injectable()
export class AwsService {
  s3: S3;
  s3Client: S3Client;
  constructor() {
    this.s3 = new S3({
      credentials: {
        accessKeyId: '',
        secretAccessKey: '',
      },
      region: 'ap-northeast-2',
    });

    this.s3Client = new S3Client({
      credentials: {
        accessKeyId: '',
        secretAccessKey: '',
      },
      region: 'ap-northeast-2',
    });
  }

  async getObject({ bucketName, key }) {
    const command = new GetObjectCommand({
      Bucket: bucketName,
      Key: key,
    });

    const { Body } = await this.s3Client.send(command);
    return new StreamableFile(Body as internal.Readable);
  }

  async uploadObject({
    bucketName,
    key,
    file,
  }: {
    bucketName;
    key;
    file: Express.Multer.File;
  }) {
    const upload = new Upload({
      client: this.s3Client,
      params: {
        Bucket: bucketName,
        Key: key,
        Body: Readable.from(file.buffer),
        ContentType: file.mimetype,
      },
    });

    return await upload.done();
  }
}
