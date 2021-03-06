package com.yammer.metrics.tests

import com.codahale.simplespec.Spec
import com.codahale.simplespec.annotation.test
import com.yammer.metrics.core.MeterMetric
import com.yammer.metrics.Meter
import org.specs2.mock.Mockito

class MeterSpec extends Spec with Mockito {
  class `A meter` {
    val metric = mock[MeterMetric]
    val meter = new Meter(metric)

    @test def `marks the underlying metric` = {
      meter.mark()

      there was one(metric).mark()
    }

    @test def `marks the underlying metric by an arbitrary amount` = {
      meter.mark(12)

      there was one(metric).mark(12)
    }
  }
}
