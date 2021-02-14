package es.jlaa.formatter.formatters;

public class DefaultFormatter extends CompositeFormatter{

	public DefaultFormatter() {
		super();
		this.with(new StringFormatter())
			.with(new BooleanFormatter())
			.with(new ByteFormatter())
			.with(new CharacterFormatter())
			.with(new DateFormatter())
			.with(new DoubleFormatter())
			.with(new FloatFormatter())
			.with(new IntegerFormatter())
			.with(new LongFormatter())
			.with(new ShortFormatter())
			.with(new EnumFormatter());
	}
}
