import pandas as pd

def getDataframeSize(df: pd.DataFrame) -> List[int]:
    return list(df.shape)
