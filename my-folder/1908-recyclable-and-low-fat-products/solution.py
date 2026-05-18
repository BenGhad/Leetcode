import pandas as pd

def find_products(prod: pd.DataFrame) -> pd.DataFrame:
    return prod.loc[
        (prod['low_fats'] == 'Y') & (prod['recyclable'] == 'Y'),
        ['product_id']
    ]
