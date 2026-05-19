import pandas as pd

def changeDatatype(df: pd.DataFrame) -> pd.DataFrame:
    return df.astype({"grade":"int32"})
