package com.opticdev.installer

import org.scalatest.FunSpec

class Installers extends FunSpec {

  it("can install atom plugin") {
    assert((new Atom).tryInstall("").isSuccess)
  }

  it("can install VSCode plugin") {
    val location = FindIDE.byBundleId(Config.ides("VSCode").bundleId).get
    assert((new VSCode).tryInstall(location).isSuccess)
  }

  it("can install the jetbrains plugins") {
    val location = FindIDE.byBundleId(Config.ides("WebStorm").bundleId).get
    assert((new JetBrains).tryInstall(location).isSuccess)
  }

  it("can install sublime plugin") {
    assert(new Sublime("3").tryInstall("").isSuccess)
  }

}
