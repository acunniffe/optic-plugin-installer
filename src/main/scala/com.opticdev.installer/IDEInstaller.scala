package com.opticdev.installer

import scala.util.Try

object IDEInstaller {

  def installIDEs(skip: String*): Map[String, Boolean] = {
    val allIDEs = findInstalledIDEs.filterNot(ide => skip.contains(ide._1))

    val installResults = allIDEs.map(i=> (i._1, Try(i._2.installer.tryInstall(FindIDE.byBundleId(i._2.bundleId).get)).flatten))

    installResults.mapValues(_.isSuccess)
  }

  def findInstalledIDEs: Map[String, Config.IDE] =
    Config.ides.filter(i=> FindIDE.byBundleId(i._2.bundleId).isDefined)

}
