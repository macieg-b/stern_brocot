package mba.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Node {
	private int level;
	private int x;
	private int y;

	@Override
	public String toString() {
		return String.format("\t%d/%d\t", x, y);
	}
}
