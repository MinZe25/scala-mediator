package minze25.scalamediator
package core

import scala.reflect.runtime.universe._

trait IHandlerService {
  def howManySingleHandlers: Int

  def howManyMultiHandlers: Int

  def getSingleCommandHandler[COMMAND <: SingleCommand[TARGET_TYPE] : TypeTag, TARGET_TYPE]
  (command: SingleCommand[TARGET_TYPE])(implicit tag: TypeTag[SingleCommand[TARGET_TYPE]])
  : Option[SingleCommandHandler[COMMAND, TARGET_TYPE]]

  def getMultipleCommandHandlers(command: MultiCommand): List[MultiCommandHandler[MultiCommand]]
}