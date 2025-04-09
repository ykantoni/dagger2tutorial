package com.homesystems;

import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import dagger.Binds;

@Module
abstract class HelloWorldModule {
  @Binds
  @IntoMap
  @StringKey("hello")
  abstract Command helloWorldCommand(HelloWorldCommand command);
}