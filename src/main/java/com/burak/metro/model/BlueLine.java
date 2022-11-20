package com.burak.metro.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Entity
@Table(name = "blue_line")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BlueLine extends Line {

}
