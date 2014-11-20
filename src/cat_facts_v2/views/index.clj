(ns cat-facts-v2.views.index
  (:require
   [cat-facts-v2.config        :as config]
   [hiccup.core                :as hiccup]
   [hiccup.page                :as page]))

(defn render
  [{:keys [title recipient-name image-folder facts cats-of-the-day]}]
  (hiccup/html (page/doctype :html5)
               [:html
                [:head
                 [:meta {:charset "utf-8"}]
                 [:title "Aloha from Cat Facts!"]]
                [:body {:style "color:#333;"}
                 [:div.whole {:style "width:100%; margin:auto;"}
                  [:div.container {:style "font-family: Tahoma, Arial, Geneva; sans-serif; font-size: 12px; color: #333;"}
                   [:div.content {:style "margin: auto;"}
                    [:h1 {:style "color: #B74C11;"} "Cat Facts!"]
                    [:h2 (or title "Fascinating Facts Featuring Furry Feline Friends")]
                    [:h3 {:style "color: #B74C11;"} (format "Aloha %s! Here are your daily cat facts!" recipient-name)]
                    [:p "We are your daily source of all things cat. We have an exciting programme for you today, so stick around, it's time to learn us some cats!"]
                    [:div.image {:style "width:20%; float:right;"}
                     [:img {:style "max-width: 100%" :src (format "%s/images/%s/header.jpg" config/app-base-url  image-folder)}]]
                    [:br]
                    [:ul {:style "color: #B74C11;"}
                     [:p {:style "font-size: 2em;"}]
                     (for [[fact image-name] facts]
                       [:span
                        [:li {:style "color:#333; font-size:1em;"} fact]
                        [:p
                         [:img {:style "max-width: 335px;" :src (format "%s/images/%s/%s" config/app-base-url image-folder image-name)}]]])]
                    [:h3 {:style "color: #B74C11;"} "Cats of the day"]
                    [:p "Not had enough of your purring pals to leave you catisfied? Here are our top Santa cats for your purr-usal!"]
                    [:br]
                    (for [[cat-caption image-name] cats-of-the-day]
                      [:p
                       [:img {:style "max-width: 335px;" :src (format "%s/images/%s/%s" config/app-base-url image-folder image-name)}]]
                      [:p cat-caption])]]]]]))
