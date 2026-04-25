package com.company.enroller.persistence;

import java.util.Collection;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.company.enroller.model.Participant;

@Component("participantService")
public class ParticipantService {

	DatabaseConnector connector;

	public ParticipantService() {
		connector = DatabaseConnector.getInstance();
	}

	public Collection<Participant> getAll() {
		String hql = "FROM Participant";
		Query query = connector.getSession().createQuery(hql);
		return query.list();
	}

    public Participant findByLogin(String id) {
        String hql = "FROM Participant p WHERE p.login = :login";
        Query query = connector.getSession().createQuery(hql);
        query.setParameter("login", id);
        return (Participant) query.uniqueResult();
    }

}
