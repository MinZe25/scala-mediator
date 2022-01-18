package io.github.minze25.scalamediator
package example.main

import core.{IHandlerService, IMediator}
import example.handlers.getEmployee.GetEmployee
import example.handlers.postEmployee.PostEmployeeCommand
import example.handlers.{GetBook, PostBook}
import modules.{ClassScannerModule, MediatorModule}

import com.google.inject.{Guice, Inject, Singleton}
import net.codingwell.scalaguice.ScalaModule


object MainAppMultipleInjectors extends App {
  val injector = Guice.createInjector(new ClassScannerModule("minze25.scalamediator.example.handlers"),
    new ClassScannerModule("minze25.scalamediator.example.app.handlers"))
  val instance = injector.getInstance(classOf[IHandlerService])
  val size = instance.howManySingleHandlers
  println(s"There are $size single handlers")
  val sizeMulti = instance.howManyMultiHandlers
  println(s"There are $sizeMulti multi handlers")

}
@Singleton
class AppRunner @Inject()(val mediator: IMediator) {
  println(mediator.send(GetBook()))
  println(mediator.send(GetEmployee()))
  mediator.publish(PostEmployeeCommand())
  mediator.send(PostBook())
}

object MainAppModulesCombine extends App {
  val injector = Guice.createInjector(new ModuleCombiner)
  val size = injector.getInstance(classOf[IHandlerService]).howManySingleHandlers
  println(s"There are $size handlers")
  val mediator = injector.getInstance(classOf[AppRunner])
  class ModuleCombiner extends ScalaModule {
    override def configure(): Unit = {
      install(new ClassScannerModule("io.github.minze25.scalamediator.example.app.handlers"))
      install(new ClassScannerModule("io.github.minze25.scalamediator.example.handlers"))
      install(new MediatorModule)
    }
  }
}
