package com.example.messagingstompwebsocket;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Transient
	private String command;
	private String content;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Log log = (Log) o;
		return id != null && Objects.equals(id, log.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
