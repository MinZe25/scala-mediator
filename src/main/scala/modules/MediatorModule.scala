package minze25.scalamediator
package modules

import core.{HandlerService, IHandlerService, IMediator, MultiCommand, SingleCommand}

import com.google.inject.Inject
import Exceptions.SingleHandlerNotFound
import net.codingwell.scalaguice.ScalaModule

import scala.reflect.runtime.universe._

class MediatorModule extends ScalaModule {
  override def configure(): Unit = {
    bind[IHandlerService].to[HandlerService]
    bind[IMediator].to[Mediator].asEagerSingleton()
  }
}

private sealed class Mediator @Inject()(handlerService: IHandlerService) extends IMediator {
  override def publish(command: MultiCommand): Unit = handlerService
    .getMultipleCommandHandlers(command).foreach(_.handle(command))


  override def send
  [ReturnType](command: SingleCommand[ReturnType])(implicit tag: TypeTag[SingleCommand[ReturnType]]): ReturnType = {
    handlerService.getSingleCommandHandler[SingleCommand[ReturnType], ReturnType](command) match {
      case Some(handler) => handler.handle(command)
      case None => throw new SingleHandlerNotFound(command)
    }
  }
}

