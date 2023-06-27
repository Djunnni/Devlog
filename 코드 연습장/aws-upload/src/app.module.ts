import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { AwsService } from './aws';

@Module({
  imports: [],
  controllers: [AppController],
  providers: [AppService, AwsService],
})
export class AppModule {}
