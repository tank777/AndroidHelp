
public boolean onQueryTextChange(String newText) {
        final List<ModelInfo> filteredModelList = filter(modelInfoList, newText);
        if (filteredModelList.size() != 0) {
            modelAdapter.setFilter(filteredModelList);
        } else {
            filteredModelList.add(modelInfoList.get(0));
            modelAdapter.setFilter(filteredModelList);
        }
        return true;
    }

    private List<ModelInfo> filter(List<ModelInfo> modelInfoList, String query) {
        query = query.toLowerCase();

        final List<ModelInfo> filteredModelList = new ArrayList<>();
        for (ModelInfo model : modelInfoList) {
            final String text = model.toString().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }



if (isFromEmojiLayout) {
                    y = szWindow.y > (y + floatRightContent.getHeight() + getStatusBarHeight() + widgetEmojiRightRelativeLayout.getHeight()/2) ? y : (y - widgetEmojiRightRelativeLayout.getHeight()/2);
                }


 if (isFromEmojiLayout) {

                    y = szWindow.y > (y + floatLeftContent.getHeight() + getStatusBarHeight() + widgetEmojiLeftRelativeLayout.getHeight()/2) ? y : (y - widgetEmojiLeftRelativeLayout.getHeight()/2);

                }
