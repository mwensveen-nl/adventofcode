package nl.mwensveen.adventofcode.year_2021.day_08;

import com.google.common.base.Objects;

public class Digit {

	static final Digit ONE = Digit.builder().withC().withF().build();
	static final Digit FOUR = Digit.builder().withB().withC().withD().withF().build();
	static final Digit SEVEN = Digit.builder().withA().withC().withF().build();
	static final Digit EIGHT = Digit.builder().withA().withB().withC().withD().withE().withF().withG().build();

	private final boolean a;
	private final boolean b;
	private final boolean c;
	private final boolean d;
	private final boolean e;
	private final boolean f;
	private final boolean g;

	public int count() {
		return (a ? 1 : 0) + (b ? 1 : 0) + (c ? 1 : 0) + (d ? 1 : 0) + (e ? 1 : 0) + (f ? 1 : 0) + (g ? 1 : 0);
	}

	public boolean isA() {
		return a;
	}

	public boolean isB() {
		return b;
	}

	public boolean isC() {
		return c;
	}

	public boolean isD() {
		return d;
	}

	public boolean isE() {
		return e;
	}

	public boolean isF() {
		return f;
	}

	public boolean isG() {
		return g;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (!getClass().equals(other.getClass())) {
			return false;
		}
		Digit castOther = (Digit) other;
		return Objects.equal(a, castOther.a) && Objects.equal(b, castOther.b) && Objects.equal(c, castOther.c)
				&& Objects.equal(d, castOther.d) && Objects.equal(e, castOther.e) && Objects.equal(f, castOther.f)
				&& Objects.equal(g, castOther.g);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(a, b, c, d, e, f, g);
	}

	private Digit(Builder builder) {
		this.a = builder.a;
		this.b = builder.b;
		this.c = builder.c;
		this.d = builder.d;
		this.e = builder.e;
		this.f = builder.f;
		this.g = builder.g;
	}

	public Builder toBuilder() {
		return new Builder(this);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private boolean a;
		private boolean b;
		private boolean c;
		private boolean d;
		private boolean e;
		private boolean f;
		private boolean g;

		public Builder() {
		}

		public Builder(Digit object) {
			this.a = object.a;
			this.b = object.b;
			this.c = object.c;
			this.d = object.d;
			this.e = object.e;
			this.f = object.f;
			this.g = object.g;
		}

		public Builder withA() {
			this.a = true;
			return this;
		}

		public Builder withB() {
			this.b = true;
			return this;
		}

		public Builder withC() {
			this.c = true;
			return this;
		}

		public Builder withD() {
			this.d = true;
			return this;
		}

		public Builder withE() {
			this.e = true;
			return this;
		}

		public Builder withF() {
			this.f = true;
			return this;
		}

		public Builder withG() {
			this.g = true;
			return this;
		}

		public Digit build() {
			return new Digit(this);
		}

		public Builder with(int cp) {
			if (cp == 'a')
				withA();
			if (cp == 'b')
				withB();
			if (cp == 'c')
				withC();
			if (cp == 'd')
				withD();
			if (cp == 'e')
				withE();
			if (cp == 'f')
				withF();
			if (cp == 'g')
				withG();
			return this;
		}
	}
}
