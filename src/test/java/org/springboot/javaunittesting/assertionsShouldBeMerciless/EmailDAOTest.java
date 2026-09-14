package org.springboot.javaunittesting.assertionsShouldBeMerciless;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class EmailDAOTest {

    private EmailDAO email;

    @Test
    void shouldRemoveEmailByState() {
        // given
        Email pending = createAndSaveEmail("pending","content pending",
                "abc@def.com", Email.PENDING);
        Email failed = createAndSaveEmail("failed","content failed",
                "abc@def.com", Email.FAILED);
        Email sent = createAndSaveEmail("sent","content sent",
                "abc@def.com", Email.SENT);

        // when
        email.removeByState(Email.FAILED);

        // then
        assertThat(email.findAll()).
                doesNotContain(failed);

        assertThat(email.findAll()) // adding more assertions like this is good, as it now truly tests the database removal
                .isNotEmpty()       // of the field and not just that the db doesnt have the field anymore
                .doesNotContain(failed);

        assertThat(email.findAll())
                .isNotEmpty()
                .contains(pending, sent);
    }

    private Email createAndSaveEmail(String pending, String contentPending, String mail, String pending1) {
        return null;
    }

}