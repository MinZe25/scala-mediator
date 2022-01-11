package io.github.minze25.scalamediator
package core

import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._

/**
 * Base Command Handler
 *
 * @tparam COMMAND     The command type
 * @tparam TARGET_TYPE The return of the command
 */
sealed abstract class CommandHandler[COMMAND <: Command[TARGET_TYPE] : TypeTag, TARGET_TYPE] {
  def handle(cmd: COMMAND): TARGET_TYPE

  def messageType: Type = typeOf[COMMAND]
}

/**
 * Singleton Command Handler. It will exist only one instance of the command that handles. It can return the TARGET_TYPE
 *
 * @tparam COMMAND     The command type
 * @tparam TARGET_TYPE The return of the command
 */
abstract class SingleCommandHandler[COMMAND <: SingleCommand[TARGET_TYPE] : TypeTag, TARGET_TYPE] extends CommandHandler[COMMAND, TARGET_TYPE] {
  def handle(cmd: COMMAND): TARGET_TYPE

  override def messageType: universe.Type = typeOf[COMMAND]
}

/**
 * Multi Command Handler. A multi command handler can handle multiple commands but return no value.
 *
 * @tparam COMMAND The command type
 */
abstract class MultiCommandHandler[COMMAND <: MultiCommand : TypeTag] extends CommandHandler[COMMAND, Unit] {
  def handle(cmd: COMMAND): Unit
}