package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        String[] actual2 = "1".split(",");
        assertThat(actual).contains("1", "2");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("주어진 문자열에서 특정 위치의 문자를 가져올 수 있다.")
    void charAt() {
        Character actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("주어진 문자열의 범위를 벗어나는 위치의 문자를 가져올 경우, StringIndexOutOfBoundsException을 반환한다.")
    void stringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            "abc".charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");
    }
}
