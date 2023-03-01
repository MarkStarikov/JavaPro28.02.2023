public class OpenMethod extends MineralIndustry {
    @Override
    public Mining createExcavation() {
        return new Quarry();
    }
}
