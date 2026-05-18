import pandas as pd

def big_countries(world: pd.DataFrame) -> pd.DataFrame:
    # return world.query('area >= 3000000 or population >= 25000000').filter(items=['name','population','area'])
    return world.loc[
        (world["area"] >= 3000000) | (world["population"] >= 25000000),
        ["name", "population", "area"]
    ]
