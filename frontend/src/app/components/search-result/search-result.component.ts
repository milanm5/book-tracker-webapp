import { Component, inject, Injectable } from '@angular/core';
import { SearchResultService } from '../../services/search-result.service';
import { Observable } from 'rxjs';
import { SearchResult } from '../../model/search-result';
import { AsyncPipe } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Book } from '../../model/book';

@Component({
  selector: 'app-search-result',
  imports: [AsyncPipe, RouterLink],
  templateUrl: './search-result.component.html',
  styleUrl: './search-result.component.css'
})

@Injectable({providedIn: "root"})
export class SearchResultComponent {

  private searchResultService = inject(SearchResultService);
  public searchResult$ = new Observable<SearchResult>;
  private route = inject(ActivatedRoute);

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.searchResult$ = this.searchResultService.searchBooks(params["q"], params["page"] - 1);
    })
  }

  getCoverUrl(book: Book): string {
    const coverId = book.editions.docs.at(0)?.cover_i;
    return coverId ? "https://covers.openlibrary.org/b/id/" + coverId + '-M.jpg' : "images/no_cover_img.jpg";
  }
}
