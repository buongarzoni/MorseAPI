package com.translator.morseapi;

import com.translator.morseapi.exceptions.InvalidInputException;
import com.translator.morseapi.domain.service.TranslatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TranslatorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void is_not_morse() {
		TranslatorService translatorService = new TranslatorService();
		assertThrows(InvalidInputException.class,()->{
			translatorService.translate2Morse(".... --- .-.. .-  -- . .-.. ..A");
		});
	}

	@Test
	void invalid_morse_character() {
		TranslatorService translatorService = new TranslatorService();
		assertThrows(InvalidInputException.class,()-> translatorService.translate2Morse(".... --- .-.. .-  -- . .-.. ......."));
	}


	@Test
	void validate_morse_to_latin_alphabet() {
		TranslatorService translatorService = new TranslatorService();
		assertEquals("HOLA MELI",translatorService.translate2Human(".... --- .-.. .-  -- . .-.. .."));
	}

	@Test
	void is_not_latin() {
		TranslatorService translatorService = new TranslatorService();
		assertThrows(InvalidInputException.class,()->{
			translatorService.translate2Morse("HOLA MELI!");
		});
	}

	@Test
	void validate_latin_to_morse_alphabet() {
		TranslatorService translatorService = new TranslatorService();
		assertEquals(".... --- .-.. .-  -- . .-.. ..",translatorService.translate2Morse("HOLA MELI"));
	}

	@Test
	void is_not_binary() {
		TranslatorService translatorService = new TranslatorService();
		assertThrows(InvalidInputException.class,()->{
			translatorService.pulseToMorse("00000000110110110011100000111111000111111001a");
		});
	}

	@Test
	void validate_parse_pulse_to_morse() {
		TranslatorService translatorService = new TranslatorService();
		assertEquals(".... --- .-.. .- -- . .-.. ..",translatorService.pulseToMorse("000000001101101100111000001111110001111110011111100000001110111111110111011100000001100011111100000111111001111110000000110000110111111110111011100000011011100000000000"));
	}

}
