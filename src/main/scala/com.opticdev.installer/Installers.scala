package com.opticdev.installer
import scala.util.Try
import sys.process._
import java.net.URL
import better.files._
import File._

sealed trait Installer {
  def tryInstall(path: String) : Try[Unit]
}

class Atom extends Installer {
  override def tryInstall(path: String): Try[Unit] = Try {
    val status = "apm install optic".!
    require(status == 0)
  }
}

class VSCode extends Installer {
  override def tryInstall(path: String): Try[Unit] = Try {
    val status = Seq(path + "/Contents/Resources/app/bin/code", "-install-extension", "useoptic.optic").!
    require(status == 0)
  }
}

class JetBrains extends Installer {
  val downloadDestination = File("/tmp/jetbrains.zip")
  override def tryInstall(path: String): Try[Unit] = Try {
    val targetDirectory = File(path) / "Contents" / "plugins"
    (new URL(Config.jetbrainsplugin) #> downloadDestination.toJava).!!
    downloadDestination.unzipTo(targetDirectory)
  }
}

class Sublime(version: String) extends Installer {
  val downloadDestination = File("/tmp/sublime.zip")
  override def tryInstall(path: String): Try[Unit] = Try {
    val targetDirectory = home / "Library" / "Application Support" / s"Sublime Text $version" / "Packages"
    (new URL(Config.sublimeplugin) #> downloadDestination.toJava).!!
    downloadDestination.unzipTo(targetDirectory)
  }
}

