package org.jsp.ecommerceapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class UserOrder {

	private long id;
	private LocalDateTime ordered_time;
	private LocalDate delivery_time;
	@OneToMany
	private List<Product> products;
	@ManyToOne
	private User user;

}
