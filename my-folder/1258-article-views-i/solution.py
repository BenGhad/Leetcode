import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    ids = views.loc[
        views['author_id'].eq(views['viewer_id']),
        "author_id"
    ].unique()

    return pd.DataFrame({"id" : sorted(ids)})
