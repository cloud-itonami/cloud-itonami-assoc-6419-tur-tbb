(ns association.facts
  "Industry rule/history catalog for the Türkiye Bankalar Birliği
  (TBB, Banks Association of Turkey) -- a 39th industry-association-level
  source (see cloud-itonami-assoc-6419-jpn-zenginkyo,
  -6419-deu-bankenverband, -6419-fra-fbf, -6419-aus-aba, -6419-are-ubf,
  -6419-vnm-vnba, -6419-phl-bap, -6419-esp-aeb for the first eight)
  per ADR-2607141700 (cloud-itonami-compliance-fact-federation). The
  NINTH entry aligned to ISIC 6419 (other monetary intermediation /
  banking). Fills Turkey's previously-open association-axis gap
  (noted honestly at tick 114) -- Turkey now has real, individually
  verified facts across ALL THREE axes (municipality:
  cloud-itonami-municipality-tur-ankara, tick 113; country:
  cloud-itonami-iso3166-tur statute.facts, tick 114; association:
  this entry, tick 115).

  Both entries directly WebFetch-verified against tbb.org.tr's own
  pages: the 'Vision Mission Values' page states 'Kurulduğu 1958
  yılından bu yana' (since its founding in 1958), and the
  'Milestones' (Kilometre Taşları) page gives the exact founding date
  as '8 Ekim'de Kuruldu' (Established on October 8) under the 1958
  heading -- used as the more precise :established-date. The same
  Milestones page separately confirms under its 2007 heading that
  'Bireysel Müşteriler Hakem Heyeti uygulaması hayata geçirildi'
  (Individual Customer Arbitration Board application was
  implemented), a consumer-protection dispute-resolution mechanism.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"tbb"
   [{:association-rule/id "tbb.founding-1958-10-08"
     :association-rule/title "TBB founding (Milestones / Kilometre Taşları)"
     :association-rule/association "tbb"
     :association-rule/isic "6419"
     :association-rule/country "TUR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.tbb.org.tr/tbb-hakkinda/kilometre-taslari"
     :association-rule/url-provenance :official-tbb-org-tr
     :association-rule/established-date "1958-10-08"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}
    {:association-rule/id "tbb.individual-customer-arbitration-board-2007"
     :association-rule/title "Individual Customer Arbitration Board implementation (Milestones / Kilometre Taşları)"
     :association-rule/association "tbb"
     :association-rule/isic "6419"
     :association-rule/country "TUR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.tbb.org.tr/tbb-hakkinda/kilometre-taslari"
     :association-rule/url-provenance :official-tbb-org-tr
     :association-rule/established-date "2007"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:consumer-protection}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-6419-tur-tbb Wave 0 (ADR-2607141700): "
                 (count (get catalog "tbb")) " TBB entries seeded "
                 "with tbb.org.tr citations. "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
