package minze25.scalamediator
package Exceptions

import core.SingleCommand

class SingleHandlerNotFound(private val command: SingleCommand[_]) extends Exception(s"No handler found for command: ${command.getClass.getSimpleName}") {

}