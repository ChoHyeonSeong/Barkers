package com.jhs.varkers.account;

import com.jhs.varkers.listening.ListeningService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {
    private final AccountDAO dao;
    private final ModelMapper mapper;
    private final ListeningService listeningService;

    @Override
    public void createAccount(AccountDTO dto) {
        dao.createAccount(mapper.map(dto,AccountEntity.class));
    }

    @Override
    public Long createAccountAndReturnId(AccountDTO dto) {
        AccountEntity entity = mapper.map(dto,AccountEntity.class);
        dao.createAccount(entity);
        return entity.getId();
    }

    @Override
    public AccountDTO readAccount(Long id) {
        return mapper.map(dao.readAccount(id),AccountDTO.class);
    }

    @Override
    public void updateAccount(AccountDTO dto) {
        AccountEntity entity = dao.readAccount(dto.getId());
        entity.updateAccount(dto.getName(),dto.getNickname(),dto.getProfileImage(),dto.getDescription());
    }

    @Override
    public void deleteAccount(Long id) {
        dao.deleteAccount(id);
    }
}
