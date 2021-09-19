package com.example.actions.sample

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SampleTest {

    @Test
    @DisplayName("GitHub Actions CI를 위한 샘플 테스트")
    fun sample() {
        Assertions.assertThat(true).isEqualTo(true)
    }
}