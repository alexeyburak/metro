package com.burak.metro.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "green_line")
@Getter
@Setter
@RequiredArgsConstructor
public class GreenLine extends Line {

}
