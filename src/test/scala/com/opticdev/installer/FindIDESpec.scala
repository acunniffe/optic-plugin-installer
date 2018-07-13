package com.opticdev.installer

import org.scalatest.FunSpec

class FindIDESpec extends FunSpec {
  it("can find an app that is installed") {
    assert(FindIDE.byBundleId("com.apple.Terminal").isDefined)
  }

  it("can not find an app that is installed") {
    assert(FindIDE.byBundleId("com.apple.fake").isEmpty)
  }
}
