package io.github.minze25.scalamediator
package core

import scala.reflect.runtime.universe._

trait IMediator {
  def publish(command: MultiCommand): Unit

  def send[ReturnType](command: SingleCommand[ReturnType])(implicit tag: TypeTag[SingleCommand[ReturnType]]): ReturnType
}

