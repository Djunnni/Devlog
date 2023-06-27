import { Injectable } from '@nestjs/common';
import { AwsService } from './aws';
import { randomUUID } from 'crypto';

@Injectable()
export class AppService {
  constructor(private readonly awsService: AwsService) {}

  async download() {
    return this.awsService.getObject({
      bucketName: 'daniel-c3-upload',
      key: '33c1e56c-4add-4379-ad00-a05eb55ad692/package.pdf',
    });
  }

  async upload(file: Express.Multer.File) {
    return this.awsService.uploadObject({
      bucketName: 'daniel-c3-upload',
      key: randomUUID() + '/' + file.originalname,
      file,
    });
  }
}
