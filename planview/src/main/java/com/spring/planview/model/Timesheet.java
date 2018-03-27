package com.spring.planview.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "time_sheet")
public class Timesheet {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		@Column(name = "empId")
		private Integer empId ;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getEmpId() {
			return empId;
		}
		public void setEmpId(Integer empId) {
			this.empId = empId;
		}
		public Integer getTic_Id() {
			return tic_Id;
		}
		public void setTic_Id(Integer tic_Id) {
			this.tic_Id = tic_Id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getTimelogged() {
			return timelogged;
		}
		public void setTimelogged(Integer timelogged) {
			this.timelogged = timelogged;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Column(name = "employee_name")
		private Integer tic_Id;
		private String name;
		private Integer timelogged;
		private String description;

}
