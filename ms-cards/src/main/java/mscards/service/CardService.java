package mscards.service;

import lombok.RequiredArgsConstructor;
import mscards.entities.Card;
import mscards.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repo;
    @Transactional
    public Card createCard(Card card) {
        return repo.save(card);
    }

    public List<Card> getCardsPerIncome(Long income) {
        BigDecimal clientIncome = BigDecimal.valueOf(income);
        return repo.findByIncomeLessThanEqual(clientIncome);
    }
}
