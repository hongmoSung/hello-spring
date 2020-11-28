package io.hongmo.hellospring.repository;

import io.hongmo.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager entityManager;

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List resultList = entityManager.createQuery("select m from Member m where m.name = :name").setParameter("name", name).getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public List<Member> selectAll() {
        return entityManager.createQuery("select m from Member m", Member.class).getResultList();
    }
}
