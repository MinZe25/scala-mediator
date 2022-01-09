package minze25.scalamediator
package modules

import core.{MultiCommand, MultiCommandHandler, SingleCommand, SingleCommandHandler}

import net.codingwell.scalaguice.{ScalaModule, ScalaMultibinder}
import org.reflections.Reflections

import java.lang.reflect.Modifier
import scala.jdk.CollectionConverters.SetHasAsScala

class ClassScannerModule(private val packageToScan: String) extends ScalaModule {
  override def configure(): Unit = {
    provideCommandHandlers()
  }

  private def provideCommandHandlers(): Unit = {
    val multiBinderSingle = ScalaMultibinder.newSetBinder[SingleCommandHandler[SingleCommand[Any], Any]](binder)
    scan(packageToScan, classOf[SingleCommandHandler[SingleCommand[Any], Any]]) { impl =>
      multiBinderSingle.addBinding.to(impl)
    }
    val multiBinderMultiple = ScalaMultibinder.newSetBinder[MultiCommandHandler[MultiCommand]](binder)
    scan(packageToScan, classOf[MultiCommandHandler[MultiCommand]]) { impl =>
      multiBinderMultiple.addBinding.to(impl)
    }
  }

  private def scan[T](packageScope: String, motherClass: Class[T])(subClassHandler: Class[_ <: T] => Unit): Unit = {
    new Reflections(packageScope).getSubTypesOf(motherClass).asScala
      .filterNot(c => Modifier.isAbstract(c.getModifiers))
      .foreach(subClassHandler)
  }
}

