package static_factory;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TypeSwitchTest {
  @Test
  public void switchColor_ShouldSwitchColors() {

    final var green = TypeSwitch.switchColor(TypeSwitch.AvaliableColors.BLUE);
    final var blue = TypeSwitch.switchColor(TypeSwitch.AvaliableColors.GREEN);

    assertTrue(green instanceof TypeSwitch.Green);
    assertTrue(blue instanceof TypeSwitch.Blue);
  }
}
