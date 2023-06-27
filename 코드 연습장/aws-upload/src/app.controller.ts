import {
  Controller,
  Get,
  Post,
  Res,
  StreamableFile,
  UploadedFile,
  UseInterceptors,
} from '@nestjs/common';
import { AppService } from './app.service';
import type { Response } from 'express';
import { createReadStream } from 'node:fs';
import { FileInterceptor } from '@nestjs/platform-express';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('download')
  async download(@Res({ passthrough: true }) res: Response) {
    res.contentType('application/octet-stream');
    res.set({
      'Content-Disposition': 'attachment; filename="package.pdf"',
    });
    return this.appService.download();
  }

  @Post('upload')
  @UseInterceptors(FileInterceptor('file'))
  async upload(@UploadedFile() file: Express.Multer.File) {
    console.log(file.stream);
    return await this.appService.upload(file);
  }
}
