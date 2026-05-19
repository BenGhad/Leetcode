import pandas as pd

def rearrange_products_table(df: pd.DataFrame) -> pd.DataFrame:
    return df.melt(id_vars='product_id', var_name='store', value_name='price').dropna()
