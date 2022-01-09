package minze25.scalamediator
package core

import scala.reflect.runtime.universe._

sealed abstract class Command[+RETURN_TYPE: TypeTag] {

}

/**
 * Command that does return any value.
 * The command will target one and only one handler.
 * An exception is called if the handler is not found.
 * @tparam RETURN_TYPE The type of the return value.
 */
abstract class SingleCommand[RETURN_TYPE: TypeTag] extends Command[RETURN_TYPE] {

}

/**
 * Command that does not return any value.
 * The command will target 0 or more handlers.
 */
abstract class MultiCommand extends Command[Unit] {

}