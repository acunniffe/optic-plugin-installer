package com.opticdev.installer

import org.scalatest.FunSpec

class IDEInstallerSpec extends FunSpec {

  it("can find all installed IDEs") {
    assert(IDEInstaller.findInstalledIDEs.keySet == Set(
      "VSCode", "Atom", "WebStorm", "Sublime Text 3", "IntelliJ CE"
    ))
  }

  it("can install all IDEs") {
    println(IDEInstaller.installIDEs())
  }

}
