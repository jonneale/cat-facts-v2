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
                 [:title "Aloha from Sloth Facts!"]]
                [:body {:style "color:#333;"}
                 [:div.whole {:style "width:100%; margin:auto;"}
                  [:div.container {:style "font-family: Tahoma, Arial, Geneva; sans-serif; font-size: 12px; color: #333;"}
                   [:div.content {:style "margin: auto;"}
                    [:h1 {:style "color: #B74C11;"} "Sloth Facts!"]
                    [:h2 (or title "Stationary Strange Stats Starring Slow Stationary Strangers!")]
                    [:h3 {:style "color: #B74C11;"} (format "Aloha %s! Here are your daily sloth facts!" recipient-name)]
                    [:p "We are your daily source of all things sloth. We have an exciting programme for you today, so stick around, it's time to learn us some cats!"]
                    [:div.image {:style "width: auto;"}
                     [:img {:style "max-width: 400px" :src (format "%s/images/header.jpg" config/app-base-url )}]]
                    [:br]
                    [:ul {:style "color: #B74C11;"}
                     [:p {:style "font-size: 2em;"}]
                     (for [[fact image-name] facts]
                       [:span
                        [:li {:style "color:#333; font-size:1em;"} fact]
                        [:p
                         [:img {:style "max-width: 335px;" :src (format "%s/images/%s/%s" config/app-base-url image-folder image-name)}]]])]
                    [:h3 {:style "color: #B74C11;"} "Cats of the day"]
                    [:p "Not had enough of your purring pals to leave you catisfied? Here are our top cats for your purr-usal!"]
                    [:br]
                    (for [[cat-caption image-name] cats-of-the-day]
                      [:span
                       [:p
                        [:img {:style "max-width: 335px;" :src (format "%s/images/%s/%s" config/app-base-url image-folder image-name)}]]
                       [:p cat-caption]])
                    [:h3 "Thats all for cat facts today but stay tuned for more exciting facts about your favourite tuna lovers!"]
                    [:img {:src (format "%s/images/dance.gif" config/app-base-url)}]]]]]]))
