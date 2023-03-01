public class CloseMethod extends MineralIndustry {
    @Override
    public Mining createExcavation() {
        return new Pit();
    }
}
