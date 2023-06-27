package mscards.controller;

import lombok.RequiredArgsConstructor;
import mscards.entities.Card;
import mscards.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService service;

    @PostMapping
    public ResponseEntity cardCreate(@RequestBody Card card){
        Card c = service.createCard(card);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
