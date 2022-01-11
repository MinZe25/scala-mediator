package io.github.minze25.scalamediator
package core

import com.google.inject.Inject

import scala.reflect.runtime.universe._

class HandlerService @Inject()
(singleHandlers: Set[SingleCommandHandler[SingleCommand[Any], Any]],
 multiHandlers: Set[MultiCommandHandler[MultiCommand]])
  extends IHandlerService {
  override def howManySingleHandlers: Int = singleHandlers.size

  override def howManyMultiHandlers: Int = multiHandlers.size

  override def getSingleCommandHandler[COMMAND <: SingleCommand[TARGET_TYPE] : TypeTag, TARGET_TYPE]
  (command: SingleCommand[TARGET_TYPE])(implicit tag: TypeTag[SingleCommand[TARGET_TYPE]])
  : Option[SingleCommandHandler[COMMAND, TARGET_TYPE]] =
    singleHandlers.find(handler => handler.messageType.toString == command.getClass.getName)
      .map(_.asInstanceOf[SingleCommandHandler[COMMAND, TARGET_TYPE]])


  override def getMultipleCommandHandlers(command: MultiCommand): List[MultiCommandHandler[MultiCommand]] =
    multiHandlers.filter(handler => handler.messageType.toString == command.getClass.getName).toList
}

