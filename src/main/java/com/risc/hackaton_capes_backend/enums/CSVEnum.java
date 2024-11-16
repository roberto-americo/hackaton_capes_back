package com.risc.hackaton_capes_backend.enums;

public enum CSVEnum {
	ID(0),
	TITLE(1),
	AUTHORS(2),
	SOURCE(3),
	JOURNAL(4),
	LANGUAGE(5),
	YEAR(6),
	URL(7),
	OTHER_TITLE(8),
	ABSTRACT(9),
	ABSTRACT_PT(10),
	ABSTRACT_ES(11),
	KEYWORDS(12),
	KEYWORDS_PT(13),
	KEYWORDS_ES(14),
	REFERENCES(15),
	AUTHORS_2(16),
	INSTITUTIONS(17),
	COUNTRIES(18),
	EMAIL(19),
	AUTHOR_EXTRA_INFO(20),
	EXTRA_INFO(21);
	
	private int index;
	
	CSVEnum(int index) {
		this.setIndex(index);
	}
	
	public CSVEnum getByIndex(int index) {
		return CSVEnum.values()[index];
	}

	public int getIndex() {
		return index + 1;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
