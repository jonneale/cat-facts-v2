(ns cat-facts-v2.views.index
  (:require
   [cat-facts-v2.config        :as config]
   [hiccup.core                :as hiccup]
   [hiccup.page                :as page]))

(def animal-text
  {:name   {:sloth "sloth"
            :cat "cat"
            :mole-rate "naked mole-rat"}
   :header {:sloth "Sloth Facts!"
            :cat   "Cat Facts!"
            :mole-rat "Naked Mole-Rat Facts!"}
   :title  {:sloth "Stationary Strange Stats Starring Slow Stationary Strangers!"
            :cat "Fascinating Facts Featuring Furry Feline Friends"
            :mole-rat "Natty Noteworthy News Notarising Naughty Nude Nitwits"}
   :more-header {:sloth "Not had enough of your furry funnies? Here are our top sloths"
                 :cat "Not had enough of your purring pals to leave you catisfied? Here are our top cats for your purr-usal!"}
   :goodbye     {:sloth "That's all for sloth facts today but stay tuned for more exciting facts about your favourite tree lovers!"
                 :cat "That's all for cat facts today but stay tuned for more exciting facts about your favourite tuna lovers!"
                 :mole-rat "That's all for naked mole-rat facts today, but stay tuned for more exciting facts about your favourite birthday-suited buddies!"}})

(defn animal-specific
  [part animal]
  (let [animal (or animal :cat)]
    (-> animal-text part animal)))

(defn render
  [{:keys [title recipient-name image-folder header facts animals-of-the-day animal]}]
  (hiccup/html (page/doctype :html5)
               [:html
                [:head
                 [:meta {:charset "utf-8"}]
                 [:title "Aloha from Sloth Facts!"]]
                [:body {:style "color:#333;"}
                 [:div.whole {:style "width:100%; margin:auto;"}
                  [:div.container {:style "font-family: Tahoma, Arial, Geneva; sans-serif; font-size: 12px; color: #333;"}
                   [:div.content {:style "margin: auto;"}
                    [:h1 {:style "color: #B74C11;"} (animal-specific :header animal)]
                    [:h2 (or title (animal-specific title animal))]
                    [:h3 {:style "color: #B74C11;"} (format "Aloha %s! Here are your daily %s facts!" (animal-specific :name animal) recipient-name)]
                    [:p (format "We are your daily source of all things %s. We have an exciting programme for you today, so stick around, it's time to learn us some %ss!" (animal-specific :name animal) (animal-specific :name animal))]
                    [:div.image {:style "width: auto;"}
                     [:img {:style "max-width: 400px" :src (if header
                                                             (format "%s/%s" config/app-base-url header)
                                                             (format "%s/images/header.jpg" config/app-base-url))}]]
                    [:br]
                    [:ul {:style "color: #B74C11;"}
                     [:p {:style "font-size: 2em;"}]
                     (for [[fact image-name] facts]
                       [:span
                        [:li {:style "color:#333; font-size:1em;"} fact]
                        [:p
                         [:img {:style "max-width: 335px;" :src (format "%s/images/%s/%s" config/app-base-url image-folder image-name)}]]])]
                    [:h3 {:style "color: #B74C11;"} "Sloths of the day"]
                    [:p (animal-specific :more-header animal)]
                    [:br]
                    (for [[animal-caption image-name] animals-of-the-day]
                      [:span
                       [:p
                        [:img {:style "max-width: 335px;" :src (format "%s/images/%s/%s" config/app-base-url image-folder image-name)}]]
                       [:p animal-caption]])
                    [:h3 (animal-specific :goodbye animal)]
                    [:img {:src (format "%s/images/dance.gif" config/app-base-url)}]]]]]]))
