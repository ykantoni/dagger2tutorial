package com.homesystems;

import dagger.Module;
import dagger.Provides;

@Module
abstract class SystemOutModule {
  @Provides
  static Outputter textOutputter() {
    System.out.println("Creating a new Outputter");
    return System.out::println;
  }
}
