package com.opticdev.installer

object Config {

  case class IDE(bundleId: String, installer: Installer)

  val jetbrainsplugin = "https://plugins.jetbrains.com/plugin/download?rel=true&updateId=47262"
  val sublimeplugin = "https://github.com/opticdev/optic-sublime-plugin/archive/one-zero-one.zip"

  val ides = Map(
    "Atom" -> IDE("com.github.atom", new Atom),
    "VSCode" -> IDE("com.microsoft.VSCode", new VSCode),
    "WebStorm" -> IDE("com.jetbrains.WebStorm", new JetBrains),
    "Sublime Text 2" -> IDE("com.sublimetext.2", new Sublime("2")),
    "Sublime Text 3" -> IDE("com.sublimetext.3", new Sublime("3")),
    "IntelliJ Ultimate" -> IDE("com.jetbrains.intellij.ultimate", new JetBrains),
    "IntelliJ CE" -> IDE("com.jetbrains.intellij.ce", new JetBrains),
  )

}
